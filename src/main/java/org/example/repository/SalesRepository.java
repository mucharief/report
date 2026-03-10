package org.example.repository;

import org.example.dto.EmployeeSalesDTO;
import org.example.dto.ProductSalesDTO;
import org.example.dto.SalesDTO;
import org.example.entity.Sales;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SalesRepository extends JpaRepository<Sales, Long> {

    @Query(value = "WITH monthly_sales AS (SELECT user_id, product_id, DATE_FORMAT(date_order, '%Y-%m') AS month, SUM(total) AS total_sales FROM sales GROUP BY user_id, product_id, month), ranked_sales AS (SELECT user_id, product_id, month, total_sales, RANK() OVER (PARTITION BY month, product_id ORDER BY total_sales DESC) as sales_rank FROM monthly_sales) select e.name as employee_name, p.name as product_name, rs.month, rs.total_sales FROM ranked_sales rs join product p on rs.product_id = p.id join employee e on rs.user_id = e.id WHERE rs.sales_rank = 1 order by rs.total_sales desc, rs.month asc", nativeQuery = true)
    List<EmployeeSalesDTO> findEmployeeeSalesPerMostProductPerMonth();

    @Query(value = "select DATE_FORMAT(s.date_order, '%Y-%m') AS month, p.name as product_name, sum(s.total) as total_sales from product p join sales s on p.id = s.product_id group by month, p.id", nativeQuery = true)
    List<SalesDTO> findTotalSalesPerProductPerMonth();

    @Query(value = "WITH monthly_sales AS (SELECT DATE_FORMAT(date_order, '%Y-%m') AS month, product_id, SUM(total) AS monthly_total, RANK() OVER (PARTITION BY DATE_FORMAT(date_order, '%Y-%m') ORDER BY SUM(total) DESC) as sales_rank FROM sales GROUP BY month, product_id) SELECT ms.month, p.name as product_name, ms.monthly_total FROM monthly_sales ms join product p on ms.product_id = p.id WHERE ms.sales_rank = 1 ORDER BY month ASC", nativeQuery = true)
    List<ProductSalesDTO> findBestSellerProductPerMonth();
}

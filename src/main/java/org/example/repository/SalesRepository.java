package org.example.repository;

import org.example.dto.EmployeeSalesDTO;
import org.example.dto.ProductDTO;
import org.example.dto.SalesDTO;
import org.example.entity.Sales;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SalesRepository extends JpaRepository<Sales, Long> {

    @Query(value = "select e.name, p.name, monthname(s.date_order), sum(s.total) from product p join sales s on p.id = s.product_id join employee e on e.id = s.user_id group by monthname(s.date_order), p.name, e.name", nativeQuery = true)
    List<EmployeeSalesDTO> findEmployeeeSalesPerMostProductPerMonth();

    @Query(value = "select p.name, monthname(s.date_order), sum(s.total) as sales from product p join sales s on p.id = s.product_id group by monthname(s.date_order), p.name", nativeQuery = true)
    List<SalesDTO> findTotalSalesPerProductPerMonth();

    @Query(value = "select p.name, monthname(s.date_order) from product p join sales s on p.id = s.product_id group by monthname(s.date_order), p.name", nativeQuery = true)
    List<ProductDTO> findSoldProductPerMonth();
}

//package com.example.demo.controllers;
//
//import com.example.demo.repos.CompanyRepository;
//import com.example.demo.entities.Company;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.DeleteMapping;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.PutMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.ResponseStatus;
//import org.springframework.web.bind.annotation.RestController;
//
//import java.util.List;
//import java.util.Optional;
//
//@RestController
//public class CompanyController {
//
//    @Autowired
//    private CompanyRepository repo;
//
//    //Home Page
//    @GetMapping("/")
//    public String welcome()
//    {
//        return "<html><body>"
//                + "<h1>WELCOME</h1>"
//                + "</body></html>";
//    }
//
//    // Get All Notes
//    @GetMapping("/company")
//    public List<Company> getAllNotes()
//    {
//        return repo.findAll();
//    }
//
//    // Get the company details by
//    // ID
//    @GetMapping("/company/{id}")
//    public Company getCompanyById(
//            @PathVariable(value = "id") int id)
//    {
//        return repo.findById(id);
//    }
//
//
//    @PostMapping("/company")
//    @ResponseStatus(HttpStatus.CREATED)
//    public Company addCompany(
//            @RequestBody Company company)
//    {
//        return repo.save(company);
//    }
//
//    @DeleteMapping("/delete/{id}")
//    public void deleteStudent(
//            @PathVariable(value = "id") int id)
//    {
//        repo.deleteById(id);
//    }
//
//    @PutMapping("/company/{id}")
//    public ResponseEntity<Object> updateStudent(
//            @RequestBody Company company,
//            @PathVariable int id)
//    {
//
//        Optional<Company> companyRepo
//                = Optional.ofNullable(
//                repo.findById(id));
//
//        if (!companyRepo.isPresent())
//            return ResponseEntity
//                    .notFound()
//                    .build();
//
//        company.setId(id);
//
//        repo.save(company);
//
//        return ResponseEntity
//                .noContent()
//                .build();
//    }
//}

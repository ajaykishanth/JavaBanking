package com.task.bank.service.impl;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import org.apache.poi.ss.usermodel.*;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.task.bank.entity.Student;
import com.task.bank.repository.StudentRepository;
import com.task.bank.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService {
    
    @Autowired
    private StudentRepository studentRepo;

    @Override
    public void porcessExcelFile(File file) throws IOException {
        
        Set<Student> studentSet = new HashSet<>();
        
        FileInputStream fis = new FileInputStream(file);
        Workbook workbook = new XSSFWorkbook(fis); 
        Sheet sheet = workbook.getSheet("Sheet1"); 

        Iterator<Row> rowIterator = sheet.iterator();
        while (rowIterator.hasNext()) {
            Row row = rowIterator.next();
            
            if (row.getRowNum() == 0) continue;
 
            String name = "";
            String rollNo = "";
            
            Cell nameCell = row.getCell(0); 
            Cell rollNoCell = row.getCell(1);

            // Handle name cell (string value)
            if (nameCell != null && nameCell.getCellType() == CellType.STRING) {
                name = nameCell.getStringCellValue();
            }

            // Handle rollNo cell (numeric value or string)
            if (rollNoCell != null) {
                if (rollNoCell.getCellType() == CellType.STRING) {
                    rollNo = rollNoCell.getStringCellValue();
                } else if (rollNoCell.getCellType() == CellType.NUMERIC) {
                    rollNo = String.valueOf(rollNoCell.getNumericCellValue());
                }
            }
            
            
            // Validate data before proceeding
            if (rollNo != null && !rollNo.isEmpty() && name != null && !name.isEmpty()) {
                Student student = new Student();
                student.setName(name);

                try {
                    student.setRollno(Integer.parseInt(rollNo)); // Parse rollNo to integer
                } catch (NumberFormatException e) {
                    // Handle invalid number format (if any)
                    continue; // Skip this student if rollNo is not a valid integer
                }
           
                // Check if the student already exists
                if (!studentRepo.findByRollno(student.getRollno()).isPresent() ) {
                    studentSet.add(student);
                    

                }
            }
        }
        
        
        studentRepo.saveAll(studentSet);
        
        // Close resources
        workbook.close();
        fis.close();
    }
}

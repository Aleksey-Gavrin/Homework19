package pro.sky.homework19.service;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import pro.sky.homework19.exeptions.BadRequestException;
import pro.sky.homework19.exeptions.EmployeeAlreadyAddedException;
import pro.sky.homework19.exeptions.EmployeeNotFoundException;
import pro.sky.homework19.exeptions.EmployeeStorageIsFullException;
import pro.sky.homework19.model.Employee;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@Service
public class EmployeeService {
    private final Map<String, Employee> employeeMap;

    public EmployeeService() {
        this.employeeMap = new HashMap<>();
    }

    public Map<String, Employee> getEmployeeMap() {
        return employeeMap;
    }

    private final int MAX_EMPLOYEES = 15;

    public static void checkStringInput(String str1, String str2) {
        if (!(StringUtils.isAlpha(str1) && StringUtils.isAlpha(str2))) {
            throw new BadRequestException();
        }
    }

    public Employee addEmployee(String firstName, String lastName, double salary, int department) {
        checkStringInput(firstName, lastName);
        if (employeeMap.size() >= MAX_EMPLOYEES) {
            throw new EmployeeStorageIsFullException();
        }
        Employee empl = new Employee(firstName, lastName, salary, department);
        if (employeeMap.containsValue(empl)) {
            throw new EmployeeAlreadyAddedException();
        } else {
            employeeMap.put(empl.getHashKey(), empl);
            return empl;
        }

    }

    public Employee findEmployee(String firstName, String lastName) {
        checkStringInput(firstName, lastName);
        String hashKey = (firstName + lastName).toLowerCase();
        if (employeeMap.containsKey(hashKey)) {
            return employeeMap.get(hashKey);
        } else {
            throw new EmployeeNotFoundException();
        }
    }

    public Employee removeEmployee(String firstName, String lastName) {
        checkStringInput(firstName, lastName);
        Employee empl = findEmployee(firstName, lastName);
        return employeeMap.remove(empl.getHashKey());
    }

    public Collection<Employee> printAll() {
        return Collections.unmodifiableCollection(employeeMap.values());
    }

}

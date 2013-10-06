package sanych.forAimprosoft;

import com.sun.corba.se.impl.protocol.AddressingDispositionException;
import sanych.forAimprosoft.database.dao.DepartmentDao;
import sanych.forAimprosoft.database.dao.EmployeeDao;
import sanych.forAimprosoft.database.model.Employee;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created with IntelliJ IDEA.
 * User: Alexandr
 * Date: 05.10.13
 * Time: 16:10
 * To change this template use File | Settings | File Templates.
 */
public class Validator {

    private static final String EMAIL_PATTERN =
            "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                    + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

    private Pattern pattern = Pattern.compile(EMAIL_PATTERN);
    private EmployeeDao employeeDao = new EmployeeDao();
    DepartmentDao depDao=new DepartmentDao();

    public void validate(String email, String age, String date) throws ValidationException {
        Map<String, String> errors = new HashMap<>();

        if (email == null || email.equals("")) {
            errors.put("email", "Email is required");
        } else {
            Matcher matcher = pattern.matcher(email);
            if (!matcher.matches()) {
                errors.put("email", "Malformed email");
            } else if (employeeDao.exists(email)){
                errors.put("email", "Such user is already exists");
            }
        }

        try {
            int numAge = Integer.parseInt(age);
        } catch (NumberFormatException e) {
            errors.put("age", "Age should be numeric");
        }

        if (date == null || date.equals("")) {
            errors.put("date", "Date shouldn't be empty");
        }

        if (!errors.isEmpty()) {
            throw new ValidationException(errors);
        }
    }

    public void validate(String nameDep) throws ValidationException {
        Map<String, String> errors = new HashMap<>();

        if (nameDep == null || nameDep.equals("")) {
            errors.put("department", "The field must not be empty");
        } else if (depDao.existsDep(nameDep)){
            errors.put("department", "such  department is already exists");
        }
        if (!errors.isEmpty()) {
            throw new ValidationException(errors);
        }
    }

    public static class ValidationException extends Exception {

        private Map<String, String> errors;

        public ValidationException(Map<String, String> errors) {
            this.errors = errors;
        }

        public Map<String, String> getErrors() {
            return Collections.unmodifiableMap(errors);
        }
    }

}

package com.example.basejavaee.WebServlet;

import com.example.basejavaee.connect.EmployeeConnector;
import com.example.basejavaee.entities.Employee;
import com.example.basejavaee.entities.dtos.EmployeeDto;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/")
public class UserServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private EmployeeConnector employeeConnector;

    public void init() {
        employeeConnector = new EmployeeConnector();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getServletPath();

        try {
            switch (action) {
                case "/new":
                    showNewForm(request, response);
                    break;
                case "/insert":
                    insertEmployee(request, response);
                    break;
                case "/edit":
                    showEditForm(request, response);
                    break;
                case "/list":
                    listEmployee(request, response);
                    break;
                case "/delete-all":
                    deleteAll(response);
                    break;
                default:
                    listEmployee(request, response);
                    break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }

    private void listEmployee(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        List<Employee> employeeList = employeeConnector.selectAllEmployees();
        request.setAttribute("employeeList", employeeList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("list-employees.jsp");
        dispatcher.forward(request, response);
    }

    private void showNewForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("employee-form.jsp");
        dispatcher.forward(request, response);
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Employee employee = employeeConnector.selectEmployee(id);
        RequestDispatcher dispatcher = request.getRequestDispatcher("employee-form.jsp");
        request.setAttribute("employee", employee);
        dispatcher.forward(request, response);

    }

    private void insertEmployee(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        String full_name = request.getParameter("full_name");
        String birthday = request.getParameter("birthday");
        String address = request.getParameter("address");
        String position = request.getParameter("position");
        String department = request.getParameter("department");
        EmployeeDto employeeDto = new EmployeeDto(full_name, birthday, address, position, department);
        Employee newEmployee = new Employee();
        newEmployee.full_name = employeeDto.full_name;
        newEmployee.birthday = employeeDto.birthday;
        newEmployee.address = employeeDto.address;
        newEmployee.position = employeeDto.position;
        newEmployee.department = employeeDto.department;
        employeeConnector.insertEmployee(newEmployee);
        response.sendRedirect("list");
    }





    private void deleteAll(HttpServletResponse response)
            throws SQLException, IOException {
        employeeConnector.deleteAll();
        response.sendRedirect("list");

    }
}

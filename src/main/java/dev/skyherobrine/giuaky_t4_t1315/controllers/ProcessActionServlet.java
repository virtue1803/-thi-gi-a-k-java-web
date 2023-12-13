package dev.skyherobrine.giuaky_t4_t1315.controllers;

import dev.skyherobrine.giuaky_t4_t1315.enums.Roles;
import dev.skyherobrine.giuaky_t4_t1315.models.Candidate;
import dev.skyherobrine.giuaky_t4_t1315.models.Experience;
import dev.skyherobrine.giuaky_t4_t1315.services.impl.CandidateService;
import dev.skyherobrine.giuaky_t4_t1315.services.impl.ExperienceService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.time.format.DateTimeFormatter;
import java.util.List;

@WebServlet(name = "ProcessActionServlet", urlPatterns = {"/process-action-servlet", "/pas"})
public class ProcessActionServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String getAction = req.getParameter("action");
        if(getAction.equalsIgnoreCase("View Role")) {
            String getRoles = req.getParameter("select_roles").toUpperCase();

            List<Experience> list = new ExperienceService().findByRole(Roles.getRole(getRoles));
            String dataRows = "";
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

            for(Experience experience : list){
                dataRows += ("<tr><td>" + experience.getCandidate().getFullName() + "</td><td>" + experience.getCompanyName() + "</td><td>" + formatter.format(experience.getFromDate()) + "</td><td>" + formatter.format(experience.getToDate()) + "</td></tr>");
            }

            req.getServletContext().setAttribute("list_candidates_by_role", dataRows);
            req.getServletContext().getRequestDispatcher("/report1.jsp").forward(req, resp);
        } else {
            String[] splitString = getAction.split(" ");
            Long getId = Long.parseLong(splitString[2]);

            Candidate candidate = new CandidateService().findById(String.valueOf(getId)).get();
            List<Experience> experiences = candidate.getExperiences();

            String infoExp = "";
            for(Experience target : experiences) {
                infoExp += ("Mã Experience: " + target.getId() + ", Tên Công Ty: " + target.getCompanyName() + ", Ngày bắt đầu: " + target.getFromDate() + ", Ngày kết thúc: "
                        + target.getToDate() + ", Chức vụ: " + target.getRole() + ", Mô tả công ty: " + target.getWorkDesc() + "<br>");
            }

            String infos = "Mã ID: " + candidate.getId() + "<br>Họ tên: " + candidate.getFullName() + "<br>Email: " + (candidate.getEmail() == null ? "Không có" : candidate.getEmail()) + "<br>Số điện thoại: " + candidate.getPhone() + "<br>" + infoExp;

            System.out.println(1);
            req.getServletContext().setAttribute("candidate_details", infos);
            req.getServletContext().getRequestDispatcher("/candidate_details.jsp").forward(req, resp);
        }
    }
}

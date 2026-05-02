import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class ResumeServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String resume = request.getParameter("resume").toLowerCase();

        int score = 0;

        // AI-like keyword scoring logic
        if (resume.contains("java")) score += 20;
        if (resume.contains("python")) score += 20;
        if (resume.contains("html")) score += 10;
        if (resume.contains("css")) score += 10;
        if (resume.contains("sql")) score += 15;
        if (resume.contains("machine learning")) score += 25;
        if (resume.contains("ai") || resume.contains("artificial intelligence")) score += 25;
        if (resume.contains("spring boot")) score += 20;

        String feedback;

        if (score >= 80) {
            feedback = "Excellent Resume 🚀 (Highly recommended for AI roles)";
        } else if (score >= 50) {
            feedback = "Good Resume 👍 (Needs minor improvements)";
        } else {
            feedback = "Weak Resume ⚠️ (Add more technical skills)";
        }

        out.println("<h2>Resume Score: " + score + "/100</h2>");
        out.println("<h3>" + feedback + "</h3>");
    }
}
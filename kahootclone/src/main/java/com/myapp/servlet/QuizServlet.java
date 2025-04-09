package com.myapp.servlet;

import com.myapp.model.*;
import java.io.*;
import java.sql.*;

import javax.xml.crypto.Data;
import com.google.gson.Gson;
import jakarta.servlet.*; // Tomcat 10
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet("/quizServlet")
public class QuizServlet extends HttpServlet {

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        // Read the request body
        // Read the request body
        BufferedReader reader = new BufferedReader(new InputStreamReader(request.getInputStream()));
        StringBuilder sb = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null) {
            sb.append(line);
        }
        String jsonPayload = sb.toString();

        // Parse JSON using Gs on
        Gson gson = new Gson();
        QuizRequest payload = gson.fromJson(jsonPayload, QuizRequest.class);

        // Access data from the parsed payload
        String action = payload.getAction();
        Data data = payload.getData();
        // Process the action and data here as needed

        // Send a response back to the client
        response.setContentType("application/json");
        PrintWriter out = response.getWriter();
        out.write("{\"message\": \"Success\"}");
        out.flush();

        switch (action) {
            case " check": {
                System.out.println("Checking latest quiz ID to generate new quiz");
                // Need teacher_id only

                break;
            }
            case "view": {

            }
            case "incomplete": {
                System.out.println("Saved current questions and options");
                // Need teacher_id , quiz_id, question data
                break;
            }
            case "submit": {
                System.out.println("Submitting quiz, quiz status will change from draft to completed");
                // Need teacher_id and quiz_id
                break;
            }
            case "edit": {
                System.out.println("Editting quiz, fetch select quiz data");
                // Need teacher_id and quiz_id
                break;
            }
            case "use": {
                System.out.println("Fetching quiz data for use, quiz status will change from completed to Live");
                // Need teacher_id and quiz_id
                break;
            }
            case "complete": {
                System.out.println("Quiz has finished, quiz status will change from live to inactive");
                // Need teacher_id and quiz_id
                break;
            }
        }

    }
}
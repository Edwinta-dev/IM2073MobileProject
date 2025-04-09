<!DOCTYPE html>
<html>
  <head>
    <% Integer teacherId = (Integer) session.getAttribute("teacherId"); %>
    <title>Home</title>
    <meta name="viewport" content="width=device-width, initial-scale=1" />
    <link
      href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
      rel="stylesheet"
      integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
      crossorigin="anonymous"
    />
  </head>
  <body>
    <h6>Welcome to kahootclone!</h6>
    <div
      class="mb-3 quiz-action"
      id="createQuizButton"
      data-action="check"
      data-teacher-id="<%=teacherId%>"
    >
      <a href="createquiz.html"><strong>Create your next quiz here!</strong></a>
    </div>
    <div
      class="mb-3 quiz-action"
      data-action="view"
      data-teacher-id="<%=teacherId%>"
    >
      <a href="quizlist.html"><strong>View your quiz list here!</strong></a>
    </div>
    <div class="mb-3">
      <a href="/kahootclone/userservlet?action=logout">Logout</a>
    </div>
  </body>
  <script>
    const teacher_id = "<%= session.getAttribute("teacherId") %>";
    console.log(teacher_id);
  </script>
  <script src="../resources/public/scripts/quiz-servlet-handling"></script>
</html>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="model.Professor" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Cadastro de Professor</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
	<%
        Professor professor = (Professor) request.getAttribute("professor");
        String nome = professor != null ? professor.getNome() : "";
        String disciplina = professor != null ? professor.getDisciplina() : "";
        String id = professor != null ? professor.getId().toString() : "";
    %>
    <div class="container">
        <h1><%= professor != null ? "Editar Professor" : "Cadastrar Professor" %></h1>
        <form action="/ProjetoMaven/professor" method="post">
        	<input type="hidden" name="id" value="<%= id %>">
            <div class="mb-3">
                <label for="nome" class="form-label">Nome:</label>
                <input type="text" class="form-control" id="nome" name="nome" value="<%= nome %>" required>
            </div>
            <div class="mb-3">
                <label for="idade" class="form-label">Disciplina:</label>
                <input type="text" class="form-control" id="disciplina" name="disciplina" value="<%= disciplina %>" required>
            </div>
            <button type="submit" class="btn btn-primary">Enviar</button>
        </form>
    </div>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
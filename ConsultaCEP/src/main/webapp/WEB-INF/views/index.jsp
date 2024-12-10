<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Consulta de CEP</title>
   <!-- Bootstrap CSS -->
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/styles.css">
     <!-- jQuery and Bootstrap JS -->
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.0.10/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
	<script src="${pageContext.request.contextPath}/js/scripts.js"></script>
</head>
<body>
    <div class="container mt-5">
        <h1 class="mb-4">Consulta de CEP</h1>
        
        <div class="form-group">
            <label for="cep">Digite o CEP:</label>
            <input type="text" id="cep" class="form-control" maxlength="8" placeholder="Ex: 12345678" />
        </div>
        
        <div class="form-group form-check">
            <input type="checkbox" class="form-check-input" id="meuCheckbox" name="termos" />
            <label class="form-check-label" for="meuCheckbox">Utilizar API Externa</label>
        </div>
        
        <button class="btn btn-primary mb-3" onclick="consultarCep()">Consultar</button>
        
        <p id="resultado" class="mt-3"></p>
        
        <h2 class="mt-5">Consultas Anteriores</h2>
        <div class="table-responsive">
            <table class="table table-bordered mt-3">
                <thead class="thead-dark">
                    <tr>
                        <th scope="col">CEP</th>
                        <th scope="col">Resultado</th>
                        <th scope="col">Data/Hora</th>
                    </tr>
                </thead>
                <tbody id="tabelaConsultas">                   
                </tbody>
            </table>
        </div>
    </div>
</body>
</html>
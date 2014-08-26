<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
   <meta charset='UTF-8'>
   <title>Persona</title>
   <script>
      var validar = function() {
         var nombre = document.getElementById('nombre').value;
         var apellido = document.getElementById('apellido').value;
         var edad = document.getElementById('edad').value;
         var noEsNumero = isNaN(parseInt(edad));
         var error = '';
         
         if (nombre == '')
            error += 'Debe especificar un nombre\n';
         if (apellido == '')
            error += 'Debe especificar un apellido\n';
         if (noEsNumero || edad <= 0)
            error += 'Edad inválida';
         
         //if (error != '')
         //   window.alert(error);
         //else 
            document.forms[0].submit();
      };
   </script>
</head>
<body>
   <form action='resultado.jsp' method='post'>
      <table>
         <tr>
            <td>Nombre:</td>
            <td><input type='text' name='nombre' id='nombre'/></td>
         </tr>
         <tr>
            <td>Apellido:</td>
            <td><input type='text' name='apellido' id='apellido'/></td>
         </tr>
         <tr>
            <td>Edad:</td>
            <td><input type='text' name='edad' id='edad'/></td>
         </tr>
         <tr>
            <td colspan='2'>
               <input type='button' value='Enviar' onclick='validar()'/>
            </td>
         </tr>
      </table>
   </form>

</body>
</html>

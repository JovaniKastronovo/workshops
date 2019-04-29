<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>BORAJI.COM</title>

    <style type="text/css">
        span.error{
            color: red;
            margin-left: 5px;
        }
    </style>

    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <script type="text/javascript">
        $(function() {
            /*  Submit form using Ajax */
            $('button[type=submit]').click(function(e) {

                //Prevent default submission of form
                e.preventDefault();

                $.post({
                    url : 'savePerson',
                    data : $('form[name=personForm]').serialize(),
                    success : function(res) {

                            $('#resultContainer pre code').text(JSON.stringify(res));
                            $('#resultContainer').show();

                    }
                })
            });
        });
    </script>
</head>
<body>
<h1>Employee Input Form</h1>
<hr />

<form action="savePerson" method="post" name="personForm">
    <table>
        <tr>
            <td>Name</td>
            <td><input name="name" type="text" /></td>
        </tr>
        <tr>
            <td>Phone</td>
            <td><input name="phone" type="text" /></td>
        </tr>
        <tr>
            <td>Email</td>
            <td><input name="email" type="text" /></td>
        </tr>
        <tr>
            <td></td>
            <td><button type="submit">Submit</button></td>
        </tr>
    </table>
</form>

<!-- Result Container  -->
<div id="resultContainer" style="display: none;">
    <hr/>
    <h4 style="color: green;">JSON Response From Server</h4>
    <pre style="color: green;">
    <code></code>
   </pre>
</div>
</body>
</html>
<%--
  Page d'erreur 404 personnalisée (Not Found)
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isErrorPage="true" %>
<html>
<head>
    <title>Erreur 404 - Page Non Trouvée</title>
    <script src="https://cdn.tailwindcss.com"></script>
</head>
<body class="min-h-screen flex items-center justify-center p-6 text-gray-800">

<div class="fixed inset-0 bg-gradient-to-br from-red-100 via-pink-100 to-orange-200 z-0"></div>

<div class="relative w-full max-w-lg bg-white/90 backdrop-blur-sm p-10 rounded-2xl shadow-2xl z-10
                border border-white text-center">

    <div class="text-6xl font-extrabold text-red-600 mb-4">
        404
    </div>

    <h1 class="text-4xl font-bold text-gray-800 mb-4">
        Oups ! Page Introuvable
    </h1>

    <p class="text-lg text-gray-600 mb-8">
        Nous n'avons pas pu trouver la ressource demandée. Il se peut que le lien soit expiré ou que la page ait été déplacée.
    </p>

    <%
        // Récupère l'URI qui a causé l'erreur
        String requestedUri = (String) request.getAttribute("jakarta.servlet.error.request_uri");
    %>
    <div class="mb-8 p-4 bg-gray-50 rounded-lg border border-gray-200">
        <p class="text-sm font-semibold text-gray-700">Chemin d'accès erroné :</p>
        <code class="text-sm text-red-500 break-all"><%= (requestedUri != null) ? requestedUri : "N/A" %></code>
    </div>


    <div class="flex flex-col sm:flex-row justify-center space-y-4 sm:space-y-0 sm:space-x-4">

        <a href="${pageContext.request.contextPath}/products"
           class="bg-red-600 hover:bg-red-700 text-white font-bold py-3 px-6 rounded-xl transition duration-200 shadow-md shadow-red-300 transform hover:-translate-y-0.5">
            Accueil de l'application
        </a>

        <a href="javascript:history.back()"
           class="bg-gray-200 hover:bg-gray-300 text-gray-800 font-bold py-3 px-6 rounded-xl transition duration-200 shadow-md transform hover:-translate-y-0.5">
            Retour à la page précédente
        </a>
    </div>

</div>
</body>
</html>
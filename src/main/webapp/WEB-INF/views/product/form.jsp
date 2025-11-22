<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Ajouter Produit</title>

    <script src="https://cdn.tailwindcss.com"></script>
</head>
<body class="bg-gray-100 min-h-screen flex items-center justify-center p-4">

<div class="w-full max-w-lg bg-white p-8 rounded-lg shadow-2xl">
    <h1 class="text-3xl font-extrabold text-indigo-700 mb-6 border-b-4 border-indigo-100 pb-2">
        Ajouter un Nouveau Produit
    </h1>

    <form action="${pageContext.request.contextPath}/products/" method="POST">

        <div class="mb-4">
            <label for="name" class="block text-gray-700 text-sm font-semibold mb-2">Nom du Produit:</label>
            <input type="text" id="name" name="name"
                   placeholder="Entrer le nom du produit"
                   required
                   class="shadow-sm appearance-none border border-gray-300 rounded w-full py-2 px-3 text-gray-700 leading-tight focus:outline-none focus:ring-2 focus:ring-indigo-500 focus:border-indigo-500 transition duration-150">
        </div>

        <div class="mb-4">
            <label for="description" class="block text-gray-700 text-sm font-semibold mb-2">Description:</label>
            <textarea id="description" name="description"
                      placeholder="Entrer la description du produit"
                      rows="4"
                      class="shadow-sm appearance-none border border-gray-300 rounded w-full py-2 px-3 text-gray-700 leading-tight focus:outline-none focus:ring-2 focus:ring-indigo-500 focus:border-indigo-500 transition duration-150"></textarea>
        </div>

        <div class="mb-6">
            <label for="price" class="block text-gray-700 text-sm font-semibold mb-2">Prix (DH):</label>
            <input type="number" id="price" name="price"
                   placeholder="Entrer le prix"
                   step="0.01" min="0" required
                   class="shadow-sm appearance-none border border-gray-300 rounded w-full py-2 px-3 text-gray-700 leading-tight focus:outline-none focus:ring-2 focus:ring-indigo-500 focus:border-indigo-500 transition duration-150">
        </div>

        <div class="flex items-center justify-between">
            <button type="submit"
                    class="bg-indigo-600 hover:bg-indigo-700 text-white font-bold py-2 px-4 rounded-lg focus:outline-none focus:shadow-outline transition duration-150 ease-in-out shadow-md">
                Enregistrer le Produit
            </button>
            <a href="${pageContext.request.contextPath}/products"
               class="inline-block align-baseline font-semibold text-sm text-gray-500 hover:text-indigo-800 transition duration-150">
                Annuler et Retour à la Liste
            </a>
        </div>
    </form>
</div>
</body>
</html>
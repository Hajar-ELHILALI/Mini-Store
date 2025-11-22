<%@ page import="com.ministore.mini_store.model.Product" %>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>

<html>
<head>
    <title>Liste des produits</title>

    <link href="https://cdn.jsdelivr.net/npm/tailwindcss@2.2.19/dist/tailwind.min.css" rel="stylesheet">

    <%-- <script src="https://cdn.tailwindcss.com"></script> --%>
</head>
<body class="bg-gray-50 p-6 sm:p-10">

<div class="max-w-4xl mx-auto bg-white p-6 rounded-xl shadow-lg">

    <p class="text-sm text-gray-500 mb-2">
        Nombre de produits : <span class="font-semibold text-indigo-600">${products.size()}</span>
    </p>
    <h1 class="text-3xl font-bold text-gray-900 mb-6 border-b pb-2">
        Liste des produits
    </h1>

    <form action="${pageContext.request.contextPath}/products/new" class="mb-6 inline-block">
        <button type="submit" class="text-white bg-green-600 hover:bg-green-700 focus:ring-4 focus:outline-none focus:ring-green-300 font-medium rounded-lg text-sm px-4 py-2 text-center transition duration-150 ease-in-out">
            Ajouter Produit
        </button>
    </form>

    <div class="overflow-x-auto">
        <table class="min-w-full divide-y divide-gray-200">

            <thead class="bg-indigo-600">
            <tr>
                <th scope="col" class="px-6 py-3 text-left text-xs font-medium text-white uppercase tracking-wider rounded-tl-xl">ID</th>
                <th scope="col" class="px-6 py-3 text-left text-xs font-medium text-white uppercase tracking-wider">Nom</th>
                <th scope="col" class="px-6 py-3 text-left text-xs font-medium text-white uppercase tracking-wider">Prix</th>
                <th scope="col" class="px-6 py-3 text-left text-xs font-medium text-white uppercase tracking-wider rounded-tr-xl">Date de creation</th>
                <th scope="col" class="px-6 py-3 text-left text-xs font-medium text-white uppercase tracking-wider rounded-tr-xl">Actions</th>
            </tr>
            </thead>

            <tbody class="bg-white divide-y divide-gray-200">
            <c:forEach var="product" items="${products}">
                <tr class="hover:bg-indigo-50 transition duration-150">
                    <td class="px-6 py-4 whitespace-nowrap text-sm font-medium text-gray-900">${product.id}</td>
                    <td class="px-6 py-4 whitespace-nowrap text-sm text-gray-700">${product.name}</td>
                    <td class="px-6 py-4 whitespace-nowrap text-sm text-gray-700 font-semibold text-green-600">${product.price}</td>
                    <td class="px-6 py-4 whitespace-nowrap text-sm text-gray-500">${product.created_at}</td>
                    <td class="px-6 py-4 whitespace-nowrap text-sm font-medium">
                            <%-- Formulaire de suppression --%>
                        <form action="${pageContext.request.contextPath}/products/delete" method="POST" class="inline-block">
                                <%-- Champ caché pour l'ID du produit --%>
                            <input type="hidden" name="id" value="${product.id}">

                                <%-- Bouton de soumission du formulaire --%>
                            <button
                                    type="submit"
                                    onclick="return confirm('Êtes-vous sûr de vouloir supprimer le produit : ${product.name} ?')"
                                    class="text-white bg-red-600 hover:bg-red-700 focus:ring-4 focus:outline-none focus:ring-red-300 font-medium rounded-lg text-sm px-4 py-2 text-center transition duration-150 ease-in-out"
                            >
                                Supprimer
                            </button>
                        </form>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>

</div>
</body>
</html>
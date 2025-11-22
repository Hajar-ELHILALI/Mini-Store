<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Inscription - Creative</title>
    <script src="https://cdn.tailwindcss.com"></script>
</head>
<body class="min-h-screen flex items-center justify-center p-6 text-gray-800">

<div class="fixed inset-0 bg-gradient-to-br from-purple-100 via-pink-100 to-indigo-200 z-0"></div>

<div class="relative w-full max-w-sm bg-white/90 backdrop-blur-sm p-8 rounded-2xl shadow-2xl z-10
                border border-white transform hover:scale-[1.02] transition duration-300">

    <h1 class="text-3xl font-extrabold text-purple-700 mb-8 pb-3 border-b border-purple-300 text-center tracking-wide">
        Rejoignez MiniStore
    </h1>

    <form action="${pageContext.request.contextPath}/register" method="POST">

        <div class="mb-5">
            <label for="username" class="block text-sm font-medium mb-2 text-purple-600">Nom d'utilisateur</label>
            <input id="username" type="text" name="username"
                   placeholder="Votre nom unique" required
                   class="w-full px-4 py-2 border border-gray-300 rounded-xl focus:ring-2 focus:ring-pink-500 focus:border-pink-500 transition duration-150 shadow-sm placeholder-gray-400 bg-white/80">
        </div>

        <div class="mb-5">
            <label for="email" class="block text-sm font-medium mb-2 text-purple-600">Adresse Email</label>
            <input id="email" type="email" name="email"
                   placeholder="example@domaine.com" required
                   class="w-full px-4 py-2 border border-gray-300 rounded-xl focus:ring-2 focus:ring-pink-500 focus:border-pink-500 transition duration-150 shadow-sm placeholder-gray-400 bg-white/80">
        </div>

        <div class="mb-6">
            <label for="password" class="block text-sm font-medium mb-2 text-purple-600">Mot de Passe</label>
            <input id="password" type="password" name="password"
                   placeholder="Minimum 8 caractères" required
                   class="w-full px-4 py-2 border border-gray-300 rounded-xl focus:ring-2 focus:ring-pink-500 focus:border-pink-500 transition duration-150 shadow-sm bg-white/80">
        </div>

        <button type="submit"
                class="w-full bg-gradient-to-r from-purple-600 to-pink-500 hover:from-purple-700 hover:to-pink-600 text-white font-bold py-3 rounded-xl focus:outline-none focus:ring-4 focus:ring-purple-300 transition duration-200 ease-in-out shadow-lg shadow-purple-200/50 transform hover:-translate-y-0.5">
            Créer Mon Compte
        </button>

    </form>

    <p class="mt-6 text-center text-sm text-gray-500">
        Vous avez déjà un compte ? <a href="${pageContext.request.contextPath}/login" class="text-purple-600 hover:underline font-medium">Connectez-vous ici</a>
    </p>

</div>
</body>
</html>
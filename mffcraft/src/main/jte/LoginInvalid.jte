<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>MFF Craft</title>
    <link rel="stylesheet" href="https://jc.ggu.cz/pico.css">
</head>
<body>
<main class="container">
    <article>
        <header>
            <h1><a href="/">MFF Craft</a></h1>
        </header>
        <section>
            <h2>Log in</h2>
            <p>Invalid login</p>
            <form action="/authenticate" method="post">
                <label for="username"></label><input type="text" id="username" name="username">
                <label for="password"></label><input type="password" id="password" name="password">
                <button id="submit">Submit</button>
            </form>
        </section>
        <footer>
            <p>Repository: <a href="https://github.com/yagarea/minecraft-matfyz">Github.com/yagarea/minecraft-matfyz</a>
            </p>
        </footer>
    </article>
</main>
</body>
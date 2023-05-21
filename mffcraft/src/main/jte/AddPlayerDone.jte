@param cz.blackblog.website.PlayerAdditionStatus status

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
            <h1>MFF Craft</h1>
        </header>
        <section>
            <h2>
                @if(status.isOk())
                    Success
                @else
                    Error
                @endif
            </h2>
            <blockquote>
                <p>${status.getMessage()}</p>
            </blockquote>
            <a role="button" href="/">Go to home page</a>
        </section>
        <footer>
            <p>Repository: <a href="https://github.com/yagarea/minecraft-matfyz">Github.com/yagarea/minecraft-matfyz</a></p>
        </footer>
    </article>
</main>
</body>
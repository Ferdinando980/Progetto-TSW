<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://fonts.googleapis.com/css2?family=Lobster&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="./css/styles.css">
    <link rel="stylesheet" href="./css/homepage.css">
  
    <title>HomePage</title>
</head>

<body>

    <jsp:include page="header.jsp"></jsp:include>


<div class="mainpage">


    <div class="slideshow-container">
    <nav class="navbar">
        <div class="nav-item" role=button tabindex="0" onclick="currentSlide(1)">Vinili</div>
        <div class="nav-item" role=button tabindex="0" onclick="currentSlide(2)">CD</div>
        <div class="nav-item" role=button tabindex="0" onclick="currentSlide(3)">Giradischi</div>
    </nav> 
        
            <div class = "image-label">
            <h1>VinylWaves</h1\>
        </div>
        <div class="slide-fade">
            <a href="ListaProdotti">
                <img src="assets/images/banner1.jpg" alt="Banner 1">
                <span class="sr-only">Vai alla lista prodotti</span>
            </a>
        </div>
        <div class="slide-fade">
            <a href="ListaProdotti">
                <img src="assets/images/banner2.jpg" alt="Banner 2">
                <span class="sr-only">Vai alla lista prodotti</span>
            </a>
        </div>
        <div class="slide-fade">
            <a href="ListaProdotti">
                <img src="assets/images/banner3.jpg" alt="Banner 3">
                <span class="sr-only">Vai alla lista prodotti</span>
            </a>
        </div>

        <a href="#" class="prev" onclick="moveSlideShow(-1)" aria-label="Slide Precedente">&#10094;</a>
        <a href="#" class="next" onclick="moveSlideShow(1)"aria-label="Slide Successiva">&#10095;</a>



    </div>

    <div id="info-grid" class="info-grid">
        <div class="infotextTitle">
            <h1>About us</h1>
        </div>
        <div class="infotext">
            <p>
                Siamo un gruppo di ragazzi uniti da una grande passione per la musica e il suono autentico del vinile.
                Il nostro obiettivo &egrave; portare nelle vostre case l&apos;emozione della musica su supporti fisici, dai
                <strong>vinili</strong> ai <strong>CD</strong>, fino ai <strong>giradischi</strong> perfetti per ogni ascoltatore.
            </p>
            <p>
                Abbiamo creato questo e-commerce per condividere la nostra passione e offrire una selezione curata di dischi,
                nuove uscite e grandi classici. Per noi, la musica non &egrave; solo un prodotto, ma un&apos;esperienza da vivere.
            </p>
        </div>
    </div>

</div>



<jsp:include page="footer.jsp"></jsp:include>
<script src="script/slidingbanner.js"></script>
</body>

<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://fonts.googleapis.com/css2?family=Lobster&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="./css/homepage.css">
    <link rel="stylesheet" href="./css/styles.css">
  
    <title>HomePage</title>
</head>

<body>

    <jsp:include page="header.jsp"></jsp:include>


<div class="mainpage">
    <nav class="navbar">
        <div class="nav-item">Vinili</div>
        <div class="nav-item">Giradischi</div>
        <div class="nav-item">Compact Disc</div>
    </nav> 

    <div class="slideshow-container">
    
        
            
                    <div class="slide">
                        <img src="assets/images/banner1.jpg" alt="Banner 1" style="width:100%"> 
                    </div>
                    <div class="slide">
                        <img src="assets/images/banner2.jpg" alt="Banner 2" style="width:100%">
                    </div>
                    <div class="slide">
                        <img src="assets/images/banner3.jpg" alt="Banner 3" style="width:100%">
                    </div>
                    <a class="prev" onclick="moveSlideShow(-1)">&#10094;</a>
                    <a class="next" onclick="moveSlideShow(1)">&#10095;</a>
        

          
    
        
    </div>

    <section class="info-section">
    <div class="info-grid">

    </div>
</section>
</div>

</div>

<jsp:include page="footer.jsp"></jsp:include>

<script src="script/slidingbanner.js"></script>
</body>

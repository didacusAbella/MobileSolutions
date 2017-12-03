<%-- 
    Document   : layout
    Created on : 21-nov-2017, 9.47.55
    Author     : didacusabella
--%>

<%@tag description="put the tag description here" pageEncoding="UTF-8"%>
<%@attribute name="title"%>
<%@attribute name="header" fragment="true" %>
<%@attribute name="footer" fragment="true" %>

<%-- any content can be specified here e.g.: --%>
<!DOCTYPE html>
<html lang="it" dir="ltr">
  <head>
    <meta charset="utf-8"/>
    <meta http-equiv="x-ua-compatible" content="ie=edge"/>
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no"/>
    <title>${title}</title>
    <meta name="application-name" content="MobileSolutions"/>
    <meta name="robots" content="index,follow"/>
    <meta name="googlebot" content="index,follow"/>
    <meta name="google" content="nositelinkssearchbox"/>
    <meta name="generator" content="Netbeans"/>
    <meta name="generator" content="IntellijIDEA"/>
    <meta name="rating" content="General"/>
    <meta name="author" content="Diego Avella"/>
    <meta name="author" content="Domenico Antonio Tropeano"/>
    <meta name="format-detection" content="telephone=no"/>
    <meta name="apple-mobile-web-app-capable" content="yes"/>
    <meta name="apple-mobile-web-app-status-bar-style" content="black"/>
    <meta name="apple-mobile-web-app-title" content="MobileSolutions"/>
    <meta name="mobile-web-app-capable" content="yes"/>
    <meta name="renderer" content="webkit|ie-comp|ie-stand"/>
    <meta name="x5-page-mode" content="app"/>
    <meta name="browsermode" content="application"/>
    <meta name='keywords' content='e-commerce, smarthpones, telephones, mobile'/>
    <meta name='description' content='e-commerce for smartphone'/>
    <meta name='owner' content="Carmine Attanasio"/>
    <link rel="Diego Avella" href="https://didacusabella.github.io" type="text/html"/>
    <link rel="Diego Avella" href="diego_avella@libero.it"/>
    <link rel="stylesheet" href="webjars/foundation/6.4.2/dist/css/foundation.min.css"/>
    <script src="webjars/jquery/3.2.1/jquery.min.js" type="text/javascript"></script>
    <script type="text/javascript" src="webjars/what-input/4.2.0/dist/what-input.min.js"></script>
    <script type="text/javascript" src="webjars/foundation/6.4.2/dist/js/foundation.min.js"></script>
    <script>
      $(document).foundation();
    </script>
    <noscript>
      <div>Javascript non abilitato</div>
    </noscript>
  </head>
  <body>
    <header>
      <jsp:invoke fragment="header"/>
    </header>
    <jsp:doBody/>
    <footer>
      <jsp:invoke fragment="footer"/>
    </footer>
  </body>
</html>
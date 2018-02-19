<%-- 
    Document   : loginClient
    Created on : 16-feb-2018, 10.17.26
    Author     : diego
--%>

<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="UTF-8" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="ms" %>

<ms:layout title="Mobile Solutions Accedi">
    <jsp:body>
        <div class="grid-container">
            <div class="grid-x">
                <div class="cell">
                    <form name="signinClient" action="LoginClient" method="post">
                        <fieldset class="fieldset">
                            <legend>Login</legend>
                            <label> Username
                                <input name="username" type="text" placeholder="Inserisci Username"/>
                            </label>
                            <label>Password
                                <input name="password" type="password" placeholder="Inserisci Password"/>
                            </label>
                            <label>
                                <input type="submit" value="Login" class="button"/>
                            </label>
                        </fieldset>
                    </form>
                </div>
            </div>
        </div>
    </jsp:body>
</ms:layout>
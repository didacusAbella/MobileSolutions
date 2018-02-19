<%--
  Created by IntelliJ IDEA.
  User: dtrop
  Date: 19/02/2018
  Time: 10:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="UTF-8" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="ms" %>

<ms:layout title="Mobile Solutions Administration">
    <jsp:body>
        <div class="grid-container">
            <div class="grid-x">
                <div class="cell">
                    <form name="LoginAdmin" action="LoginAdmin" method="post">
                        <fieldset class="fieldset">
                            <legend>Accedi</legend>
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

<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="first-div">
  <div class="cmn-inner">
    <h2>Add New Pet Information</h2>
    <form:form action="save" method="post" modelAttribute="petObj">
      <div class="input-form">
        <div class="clearfix">
          <span>Name:</span>
          <form:input path="name" />
        </div>
        <div class="clearfix">
          <span>Sex:</span>
          <form:input path="sex" />
        </div>
        <div class="clearfix">
          <span>Age:</span>
          <form:input path="age" />
        </div>
        <div class="clearfix">
          <span>Type:</span>
          <form:input path="type" />
        </div>
        <div class="clearfix">
          <span>Hobby:</span>
          <form:input path="hobby" />
        </div>
        <div>
          <input type="submit" value="Save">
        </div>
      </div>
    </form:form>
  </div>
</div>
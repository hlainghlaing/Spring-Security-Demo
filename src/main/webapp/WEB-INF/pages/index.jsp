<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="first-div">
  <div class="cmn-inner">
    <h2>Pet Information</h2>
    <div class="clearfix">
      <div class="text-blk">
        <h3>Care of Your Little Pets</h3>
        <p>Pets may also decrease stress, improve heart health, and
          even help children with their emotional and social skills</p>
      </div>
    </div>
  </div>
</div>
<div class="second-div">
  <div class=cmn-inner>
    <h3>Pet List Table</h3>
    <table>
      <tr>
        <th>No</th>
        <th>Name</th>
        <th>Sex</th>
        <th>Age</th>
        <th>Type</th>
        <th>Hobby</th>
        <th>Actions</th>
      </tr>
      <c:forEach items="${petList }" var="pet" varStatus="status">
        <tr>
          <td>${status.index+1}</td>
          <td>${pet.name}</td>
          <td>${pet.sex}</td>
          <td>${pet.age}</td>
          <td>${pet.type}</td>
          <td>${pet.hobby}</td>
          <td><a href="edit?id=${pet.id}">Edit</a> &nbsp;&nbsp; <a
            href="delete?id=${pet.id}"> Delete</a></td>
        </tr>
      </c:forEach>
    </table>
    <p>
      <a href="new">New Contact</a>
    </p>
  </div>
</div>
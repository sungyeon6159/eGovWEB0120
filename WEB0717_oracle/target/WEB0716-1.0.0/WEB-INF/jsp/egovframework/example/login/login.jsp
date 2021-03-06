<%--
  /**
  * Class Name : 
  * Description : 
  * Modification Information
  *
  *   수정일                   수정자                      수정내용
  *  -------    --------    ---------------------------
  *  2020. 4. 24.            최초 생성
  *
  * author 실행환경 개발팀
  * since 2009.01.06
  *
  * Copyright (C) 2009 by KandJang  All right reserved.
  */
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form"   uri="http://www.springframework.org/tags/form" %>
<c:set var="hContext" value="${pageContext.request.contextPath }"></c:set>

<!DOCTYPE html>
<html class="h-100" lang="en">

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width,initial-scale=1">
    <title>April Groupware</title>
    <!-- Favicon icon -->
    <link rel="icon" type="${hContext}/views/image/png" sizes="16x16" href="${hContext}/views/images/favicon.png">
    <!-- <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.5.0/css/all.css" integrity="sha384-B4dIYHKNBt8Bc12p+WXckhzcICo0wtJAoU8YZTY5qE0Id1GSseTk6S+L3BlXeVIU" crossorigin="anonymous"> -->
    <link href="${hContext}/views/css/style.css" rel="stylesheet">
</head>

<body class="h-100">
    
    <!--****************************************************************
        Preloader start  			LoginController 타고 내려온 login.jsp
    *******************************************************************-->
    <div id="preloader">
        <div class="loader">
            <svg class="circular" viewBox="25 25 50 50">
                <circle class="path" cx="50" cy="50" r="20" fill="none" stroke-width="3" stroke-miterlimit="10"/>
            </svg>
        </div>
    </div>
    <!--*******************
        Preloader end
    ********************-->

    <div class="login-form-bg h-100">
        <div class="container h-100">
            <div class="row justify-content-center h-100">
                <div class="col-xl-6">
                    <div class="form-input-content">
                        <div class="card login-form mb-0">
                            <div class="card-body pt-5">
                                <a class="text-center" href="#"> <h4> LOGIN</h4></a>
        
                                 <form:form commandName="searchVO"  id="login_form"  method="post" class="mt-5 mb-5 login-input" name="login_form">
                                    <div class="form-group">
                                        <input type="text"  name="id"id="id" class="form-control" placeholder="아이디" 	maxlength="20">
                                    </div>
                                    <div class="form-group">
                                        <input type="password"  name="password" id="password" class="form-control" placeholder="패스워드" maxlength="50">
                                    </div>
                                </form>
                                
                                <button type="button" class="btn login-form__btn submit w-100" id="member_login" size="20">
									로그인
								</button>
                               	 <p class="mt-5 login-form__footer" style="text-align: center"> <a  href="#" class="text-primary" onclick="goRetrieve();" >아이디 찾기  ㅣ    비밀번호 찾기</a> </p>
                        </form:form>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <!--**********************************
        Scripts
    ***********************************-->
    <script src="${hContext}/views/plugins/common/common.min.js"></script>
    <script src="${hContext}/views/js/custom.min.js"></script>
    <script src="${hContext}/views/js/settings.js"></script>
    <script src="${hContext}/views/js/gleek.js"></script>
    <script src="${hContext}/views/js/styleSwitcher.js"></script>
    
    
    <!-- jQuery (부트스트랩의 자바스크립트 플러그인을 위해 필요합니다) -->
	<!-- 모든 컴파일된 플러그인을 포함합니다 (아래), 원하지 않는다면 필요한 각각의 파일을 포함하세요 -->

	<script type="text/javascript">
	    function goRetrieve(id){
		  console.log("----goRetrieve------");
		  
		}

	    
	    
	    
	    
	    
		$("#member_login").on("click", function() {
			console.log("member_login");
			//  document.login_form.submit();
			
			var id = $("#id").val().trim();
			if (null == id || id.length <= 1) {
				$("#id").focus();
				alert("아이디를 입력하세요.");
				return;
			}

			var password = $("#password").val().trim();
			if (null == password || password.length <= 1) {
				$("#password").focus();
				alert("패스워드를 입력하세요.");
				return;
			}
			
			//동기통신 (form의 name)
			var frm = document.login_form
			frm.action = "${hContext}/login/idpass.do";
			frm.submit(); 
			
			

/* 			//출근 시간 넘기기
			var date = new Date();
			var attendTime = date.getHours();
			
			$.ajax({
				type : "POST",
				url : "${hContext}/login/login.do",
				dataType : "html",
				data : {
					"id" : $("#id").val(),
					"password" : $("#password").val(),
					"seq" : "",
					"attendTime" : attendTime,
					"attendYN" : $("#attendYN").val(),
					"leaveYN" : $("#leaveYN").val(),
					"state" : $("#state").val(),
					"workTime" : $("#workTime").val(),
					"regId" : $("#id").val(),
					"modId" : $("#id").val()
				},
				success : function(data) { //성공

				
					var jData = JSON.parse(data);
					if (null != jData && jData.msgId == "30") {
						alert(jData.msgMsg);
						//목록화면으로 이동
						goRetrieve(id);
					} else {
						alert(jData.msgMsg);
					}

				},
				error : function(xhr, status, error) {
					alert("error:" + error);
				},
				complete : function(data) {

				}

			});//--ajax
 */

		});
	</script>
</body>
</html>





    
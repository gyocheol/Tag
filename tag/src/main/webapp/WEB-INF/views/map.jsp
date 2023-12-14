<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%--yml과 propertise에서 값을 가져오는 코드--%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <%--yml과 propertise에서 값을 가져오는 코드--%>
    <spring:eval var="clientId" expression="@environment.getProperty('naverMap.clientId')"/>
    <title>찾아오시는 길</title>
    <%--naver map api--%>
    <script type="text/javascript" src="https://openapi.map.naver.com/openapi/v3/maps.js?ncpClientId=${clientId}&submodules=geocoder"></script>
    <script src="https://code.jquery.com/jquery-3.6.0.js" integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk=" crossorigin="anonymous"></script>
</head>
<body>
<h1>경일표구사</h1>

<div id="map" style="width:80%;height:75vh; margin: 0 auto; float : left"></div>
</body>
<script type="text/javascript">
    $(function() {
        initMap();
    });

    function initMap() {

        var map = new naver.maps.Map('map', {
            center: new naver.maps.LatLng(35.8636553, 128.5925372),
            zoom: 18
        });

        var marker = new naver.maps.Marker({
            map: map,
            title: "경일표구사",
            position: new naver.maps.LatLng(35.8636553, 128.5925372),
            icon: {
                content: '<img src="<c:url value="../../static/img/mapMarker.png"/>" alt="경일표구사" style="margin: 0px; padding: 0px; border: 0px solid transparent; display: block; max-width: none; max-height: none; -webkit-user-select: none; position: absolute; width: 32px; height: 32px; left: 0px; top: 0px;">',
                size: new naver.maps.Size(32, 32),
                anchor: new naver.maps.Point(16, 32)
            }
        });

        // Marker를 클릭했을 때 이벤트 핸들러 등록
        naver.maps.Event.addListener(marker, 'click', function() {
            // 클릭 시 이동할 URL 설정
            var targetUrl = "https://map.naver.com/p/entry/place/15986060?c=16.19,0,0,0,dh";

            // 새로운 창이나 현재 창으로 이동할 수 있습니다.
            window.location.href = targetUrl;
        });
    }



</script>
</html>

<%--// 위도 경도 구하는 코드--%>
<%--naver.maps.Service.geocode({--%>
<%--query: '주소'--%>
<%--}, function(status, response) {--%>
<%--if (status !== naver.maps.Service.Status.OK) {--%>
<%--return alert('Something wrong!');--%>
<%--}--%>

<%--var result = response.v2,--%>
<%--items = result.addresses;--%>

<%--if (items.length > 0) {--%>
<%--var firstItem = items[0];--%>
<%--var latitude = firstItem.y;--%>
<%--var longitude = firstItem.x;--%>

<%--console.log("위도: " + latitude);--%>
<%--console.log("경도: " + longitude);--%>
<%--} else {--%>
<%--alert('No result found');--%>
<%--}--%>
<%--});--%>
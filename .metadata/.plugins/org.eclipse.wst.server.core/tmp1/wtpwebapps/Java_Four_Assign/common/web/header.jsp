<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
    <header>
        <div id="carouselExampleCaptions" class="carousel slide" data-bs-ride="carousel">
            <div class="carousel-indicators">
                <button type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide-to="0" class="active"
                    aria-current="true" aria-label="Slide 1"></button>
                    <c:forEach var="i" begin="1" end="${model.totalItem}">
                <button type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide-to="${i }"
                    aria-label="Slide ${i }"></button>
                    </c:forEach>
            </div>
            <div class="carousel-inner">
                <div class="carousel-item active"
                    style="background-image: url('https://cdn.pixabay.com/photo/2019/03/19/19/22/mountains-4066636_1280.jpg')">
                    <div class="carousel-caption">
                        <h5>First slide label</h5>
                        <p>Some representative placeholder content for the first slide.</p>
                    </div>
                </div>
                <c:forEach var="item" items="${model.listResult }">
                <div class="carousel-item"
                    style="background-image: url('https://img.youtube.com/vi/${item.href}/maxresdefault.jpg')">
                    <div class="carousel-caption">
                        <h5>Second slide label</h5>
                        <p>Some representative placeholder content for the second slide.</p>
                    </div>
                </div>
                </c:forEach>
            </div>
            <button class="carousel-control-prev" type="button" data-bs-target="#carouselExampleCaptions"
                data-bs-slide="prev">
                <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                <span class="visually-hidden">Previous</span>
            </button>
            <button class="carousel-control-next" type="button" data-bs-target="#carouselExampleCaptions"
                data-bs-slide="next">
                <span class="carousel-control-next-icon" aria-hidden="true"></span>
                <span class="visually-hidden">Next</span>
            </button>
        </div>
    </header>


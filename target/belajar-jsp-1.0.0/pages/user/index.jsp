
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="en">
    <head>
        <!-- Required meta tags -->
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">

        <!-- Bootstrap CSS -->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-giJF6kkoqNQ00vy+HMDP7azOuL0xtbfIcaT9wjKHr8RbDVddVHyTfAAsrekwKmP1" crossorigin="anonymous">

        <title>Pendaftaran Ukm Universitas</title>
    </head>
    <body>
        <div class="container mt-4">
            <h3>Pendaftaran Ukm Universitas</h3>
        </div>
        <div class="container mt-4">
            <div class="row">
                <div class="col-md-6">
                    <form action="${pageContext.servletContext.contextPath}/user/proses" method="POST">
                        <div class="mb-3">
                            <label for="nim" class="form-label">Nim</label>
                            <input type="text" autocomplete="off" class="form-control" id="nim" name="nim" placeholder="Nim Anda">
                        </div>
                        <div class="mb-3">
                            <label for="nama" class="form-label">Nama</label>
                            <input type="text" autocomplete="off" class="form-control" id="nama" name="nama" placeholder="Nama Anda">
                        </div>
                        <div class="mb-3">
                            <label for="email" class="form-label">Email</label>
                            <input type="email" autocomplete="off" class="form-control" id="email" name="email" placeholder="Email Anda">
                        </div>

                        <div class="mb-3">
                            <label for="email" class="form-label">Jenis Kelamin</label>
                            <div class="form-check">
                                <input class="form-check-input" type="radio" name="jenis_kelamin" value="Pria" id="jenis_kelamin">
                                <label class="form-check-label" for="pria">
                                    Pria
                                </label>
                            </div>
                            <div class="form-check">
                                <input class="form-check-input" type="radio" name="jenis_kelamin" value="Wanita" id="jenis_kelamin">
                                <label class="form-check-label" for="pria">
                                    Wanita
                                </label>
                            </div>
                        </div>
                        <div class="mb-3">
                             <label for="email" class="form-label">Jurusan</label>
                            <select class="form-select" name="jurusan">
                                <option selected>Pilih Jurusan</option>
                                <c:forEach items="${listJurusan}" var="d">
                                    <option value="${d.id}">${d.namaJurusan}</option>
                                </c:forEach>
                            </select>
                        </div>
                        <div class="mb-3">
                             <label for="email" class="form-label">Ukm</label>
                            <select class="form-select" name="ukm">
                                <option selected>Pilih Ukm</option>
                                <c:forEach items="${listUkm}" var="d">
                                    <option value="${d.id}">${d.namaUkm}</option>
                                </c:forEach>
                            </select>
                        </div>
                        <button type="submit" class="btn btn-primary">Daftar</button>
                    </form>
                </div>
            </div>
        </div>

        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/js/bootstrap.bundle.min.js" integrity="sha384-ygbV9kiqUc6oa4msXn9868pTtWMgiQaeYH7/t7LECLbyPA2x65Kgf80OJFdroafW" crossorigin="anonymous"></script>
    </body>
</html>











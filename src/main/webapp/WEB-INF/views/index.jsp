<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
</head>
<body>
  <h2>Upload a File</h2>

  <!-- File upload form -->
  <form action="/FileUpload/upload" method="post" enctype="multipart/form-data" onsubmit="return validateFile()">
    <label for="file">Choose file:</label>
    <input type="file" id="file" name="file" required>
    <br><br>
    <button type="submit">Upload</button>
  </form>

  <script>
    function validateFile(){
      let file = document.getElementById("file");
      let fileInput = file.value;
      let allowedExtentions = /(\.pdf|\.xls|\.xlsx)$/i;

      if(allowedExtentions.exec(fileInput)){
        return true;
      }
      else{
        alert("Only pdf and excel files allowed.");
        fileInput.value = "";
        return false;
      }
    }

  </script>

  

</body>
</html>

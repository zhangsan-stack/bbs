<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>无标题文档</title>
    <script language="javascript">
        function doBold(){
            doc.execCommand('Bold');
            Editor.focus();
        }
        function doItalic(){
            doc.execCommand('Italic');
            Editor.focus();
        }
        function doUnderline(){
            doc.execCommand('Underline');
            Editor.focus();
        }
        function doStrikeThrough(){
            doc.execCommand('StrikeThrough');
            Editor.focus();
        }
        function doCut(){
            doc.execCommand('Cut');
            Editor.focus();
        }
        function doCopy(){
            doc.execCommand('Copy');
            Editor.focus();
        }
        function doPaste(){
            doc.execCommand('Paste');
            Editor.focus();
        }
        function doUndo(){
            doc.execCommand('Undo');
            Editor.focus();
        }
        function doPrint(){
            doc.execCommand('Print');
            Editor.focus();
        }

        function doSubscript(){
            doc.execCommand('Subscript');
            Editor.focus();
        }
        function doSuperscript(){
            doc.execCommand('Superscript');
            Editor.focus();
        }

        function SeePreview(){
            doc.body.innerHTML=form1.Preview.value;
            return false;
        }

        function EditResource(){
            form1.Preview.value=doc.body.innerHTML;
            return false;
        }
    </script>
</head>
<body>
    富文本编辑器<p></p>
        <a href="javascript:doUndo();">复原</a>&nbsp;<a href="javascript:doPrint();">打印</a>
        &nbsp;<a href="javascript:doCut();">剪切</a>&nbsp;<a href="javascript:doCopy();">复制</a>&nbsp;
        <a href="javascript:doPaste();">粘贴</a>&nbsp;

        <br>
        <a href="javascript:doBold();">粗</a>&nbsp; <a href="javascript:doItalic();">斜</a>&nbsp;<a href="javascript:doUnderline();"><u>下划</u> </a>&nbsp;
        <a href="javascript:doSuperscript();"><u>上标</u> </a>&nbsp;<a href="javascript:doSubscript();"><u>下标</u> </a>&nbsp;
        <a href="javascript:doStrikeThrough();"> 中划 </a>&nbsp;
        居左 居中 居右 缩进 缩出 图片 插入连接
        <br>

    <form id=form1 method="POST" action="">

          <textarea rows="10" cols="10" style="overflow:auto; width: 100%; height: 150px"></textarea>
          <input type="submit" value="提交" name="B1">&nbsp;
          <input type="reset" value="全部重写" name="B2">

    </form>
    <br>
    <script language="javascript">
        var doc;
        doc=document.frames.Editor.document;
        doc.designMode = "On";
        window.setTimeout('Editor.focus()',100);
    </script>



</body>
</html>
hello! this is a *.ftl</br>
<form action="/hello">
<input type="text" name="loginName" /><input type="submit" value="查询"/></br>
</form>
<#if user??>
用户：${user.loginName}
密码：${user.loginPass}
</#if>
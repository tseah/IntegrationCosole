
<%@ page import="au.com.qut.NovoControlValue"%>
<!DOCTYPE html>
<html>
<head>
<meta name="layout" content="main">
<g:set var="entityName"
	value="${message(code: 'novoControlValue.label', default: 'NovoControlValue')}" />
<title><g:message code="default.show.label" args="[entityName]" /></title>
</head>
<body>
	<a href="#show-novoControlValue" class="skip" tabindex="-1"><g:message
			code="default.link.skip.label" default="Skip to content&hellip;" /></a>
	<div class="nav" role="navigation">
		<ul>
			<li><a class="home" href="${createLink(uri: '/')}"><g:message
						code="default.home.label" /></a></li>
			<li><g:link class="list" action="list">
					<g:message code="default.list.label" args="[entityName]" />
				</g:link></li>
			<li><g:link class="create" action="create">
					<g:message code="default.new.label" args="[entityName]" />
				</g:link></li>
		</ul>
	</div>
	<div id="show-novoControlValue" class="content scaffold-show"
		role="main">
		<h1>
			<g:message code="default.show.label" args="[entityName]" />
		</h1>
		<g:if test="${flash.message}">
			<div class="message" role="status">
				${flash.message}
			</div>
		</g:if>
		<ol class="property-list novoControlValue">

			<g:if test="${novoControlValueInstance?.bundleName}">
				<li class="fieldcontain"><span id="bundleName-label"
					class="property-label"><g:message
							code="novoControlValue.bundleName.label" default="Bundle Name" /></span>

					<span class="property-value" aria-labelledby="bundleName-label"><g:fieldValue
							bean="${novoControlValueInstance}" field="bundleName" /></span></li>
			</g:if>

			<g:if test="${novoControlValueInstance?.valueName}">
				<li class="fieldcontain"><span id="valueName-label"
					class="property-label"><g:message
							code="novoControlValue.valueName.label" default="Value Name" /></span>

					<span class="property-value" aria-labelledby="valueName-label"><g:fieldValue
							bean="${novoControlValueInstance}" field="valueName" /></span></li>
			</g:if>

			<g:if test="${novoControlValueInstance?.value}">
				<li class="fieldcontain"><span id="value-label"
					class="property-label"><g:message
							code="novoControlValue.value.label" default="Value" /></span> <span
					class="property-value" aria-labelledby="value-label"><g:fieldValue
							bean="${novoControlValueInstance}" field="value" /></span></li>
			</g:if>

		</ol>
		<g:form>
			<fieldset class="buttons">
				<g:hiddenField name="id"
					value="${novoControlValueInstance?.getPK()}" />
				<g:hiddenField name="bundleName"
					value="${novoControlValueInstance?.bundleName}" />
				<g:hiddenField name="valueName"
					value="${novoControlValueInstance?.valueName}" />
				<g:link class="edit" action="edit"
					id="${novoControlValueInstance?.getPK()}" params="[bundleName: novoControlValueInstance.bundleName, valueName: novoControlValueInstance.valueName ]">
					<g:message code="default.button.edit.label" default="Edit" />
				</g:link>				
				<g:actionSubmit class="delete" action="delete"
					value="${message(code: 'default.button.delete.label', default: 'Delete')}"
					onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
			</fieldset>
		</g:form>
	</div>
</body>
</html>


<%@ page import="au.com.qut.NovoControlValue"%>
<!DOCTYPE html>
<html>
<head>
<meta name="layout" content="main">
<g:set var="entityName"
	value="${message(code: 'novoControlValue.label', default: 'NovoControlValue')}" />
<title><g:message code="default.list.label" args="[entityName]" /></title>
</head>
<body>
	<a href="#list-novoControlValue" class="skip" tabindex="-1"><g:message
			code="default.link.skip.label" default="Skip to content&hellip;" /></a>
	<div class="nav" role="navigation">
		<ul>
			<li><a class="home" href="${createLink(uri: '/')}"><g:message
						code="default.home.label" /></a></li>
			<li><g:link class="create" action="create">
					<g:message code="default.new.label" args="[entityName]" />
				</g:link></li>
		</ul>
	</div>
	<div id="list-novoControlValue" class="content scaffold-list"
		role="main">
		<h1>
			<g:message code="default.list.label" args="[entityName]" />
		</h1>
		<g:if test="${flash.message}">
			<div class="message" role="status">
				${flash.message}
			</div>
		</g:if>
		<table>
			<thead>
				<tr>
					<g:sortableColumn property="bundleName"
						title="${message(code: 'novoControlValue.bundleName.label', default: 'Bundle Name')}" />

					<g:sortableColumn property="valueName"
						title="${message(code: 'novoControlValue.valueName.label', default: 'Value Name')}" />

					<g:sortableColumn property="value"
						title="${message(code: 'novoControlValue.value.label', default: 'Value')}" />

				</tr>
			</thead>
			<tbody>
				<g:each in="${novoControlValueInstanceList}" status="i"
					var="novoControlValueInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">

						<td><g:link action="show"
								id="${novoControlValueInstance}"
								params="[bundleName: novoControlValueInstance.bundleName, valueName: novoControlValueInstance.valueName ]">
								${fieldValue(bean: novoControlValueInstance, field: "bundleName")}
							</g:link></td>

						<td>
							${fieldValue(bean: novoControlValueInstance, field: "valueName")}
						</td>

						<td>
							${fieldValue(bean: novoControlValueInstance, field: "value")}
						</td>

					</tr>
				</g:each>
			</tbody>
		</table>
		<div class="pagination">
			<g:paginate total="${novoControlValueInstanceTotal}" />
		</div>
	</div>
</body>
</html>

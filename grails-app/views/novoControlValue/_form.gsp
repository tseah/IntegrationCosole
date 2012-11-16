<%@ page import="au.com.qut.NovoControlValue" %>



<div class="fieldcontain ${hasErrors(bean: novoControlValueInstance, field: 'bundleName', 'error')} ">
	<label for="bundleName">
		<g:message code="novoControlValue.bundleName.label" default="Bundle Name" />
		
	</label>
	<g:textField name="bundleName" value="${novoControlValueInstance?.bundleName}" />
</div>

<div class="fieldcontain ${hasErrors(bean: novoControlValueInstance, field: 'valueName', 'error')} ">
	<label for="valueName">
		<g:message code="novoControlValue.valueName.label" default="Value Name" />
		
	</label>
	<g:textField name="valueName" value="${novoControlValueInstance?.valueName}" />
</div>

<div class="fieldcontain ${hasErrors(bean: novoControlValueInstance, field: 'value', 'error')} ">
	<label for="value">
		<g:message code="novoControlValue.value.label" default="Value" />
		
	</label>
	<g:textField name="value" value="${novoControlValueInstance?.value}"/>
</div>


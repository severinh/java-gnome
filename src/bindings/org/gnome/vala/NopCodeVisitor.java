package org.gnome.vala;

public class NopCodeVisitor<R> implements CodeVisitor<R>
{

    public R visitSourceFile(SourceFile sourceFile) {
        return null;
    }

    public R visitSymbol(Symbol symbol) {
        return null;
    }

    public R visitNamespace(Namespace namespace) {
        return visitSymbol(namespace);
    }

    public R visitClass(Class cls) {
        return visitSymbol(cls);
    }

    public R visitStruct(Struct struct) {
        return visitSymbol(struct);
    }

    public R visitInterface(Interface iface) {
        return visitSymbol(iface);
    }

    public R visitEnum(Enum enm) {
        return visitSymbol(enm);
    }

    public R visitEnumValue(EnumValue enumValue) {
        return visitSymbol(enumValue);
    }
    
    public R visitErrorDomain(ErrorDomain errorDomain) {
        return visitSymbol(errorDomain);
    }

    public R visitDelegate(Delegate delegate) {
        return visitSymbol(delegate);
    }

    public R visitConstant(Constant constant) {
        return visitSymbol(constant);
    }

    public R visitField(Field field) {
        return visitSymbol(field);
    }

    public R visitMethod(Method method) {
        return visitSymbol(method);
    }

    public R visitCreationMethod(CreationMethod method) {
        return visitMethod(method);
    }

    public R visitParameter(Parameter parameter) {
        return visitSymbol(parameter);
    }

    public R visitProperty(Property property) {
        return visitSymbol(property);
    }

    public R visitSignal(Signal signal) {
        return visitSymbol(signal);
    }

    public R visitDataType(DataType dataType) {
        return null;
    }

    public R visitVariable(Variable variable) {
        return visitSymbol(variable);
    }

    public R visitLocalVariable(LocalVariable localVariable) {
        return visitVariable(localVariable);
    }

    public R visitExpression(Expression expression) {
        return null;
    }

}

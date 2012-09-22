package org.gnome.vala;

public class NopCodeVisitor<R> implements CodeVisitor<R>
{

    public R visitSourceFile(SourceFile sourceFile) {
        return null;
    }

    public R visitNamespace(Namespace namespace) {
        return null;
    }

    public R visitClass(Class cls) {
        return null;
    }

    public R visitStruct(Struct struct) {
        return null;
    }

    public R visitInterface(Interface iface) {
        return null;
    }

    public R visitEnum(Enum enm) {
        return null;
    }

    public R visitEnumValue(EnumValue enumValue) {
        return null;
    }

    public R visitDelegate(Delegate delegate) {
        return null;
    }

    public R visitConstant(Constant constant) {
        return null;
    }

    public R visitField(Field field) {
        return null;
    }

    public R visitMethod(Method method) {
        return null;
    }

    public R visitCreationMethod(CreationMethod method) {
        return visitMethod(method);
    }

    public R visitParameter(Parameter parameter) {
        return null;
    }

    public R visitProperty(Property property) {
        return null;
    }

    public R visitSignal(Signal signal) {
        return null;
    }

    public R visitDataType(DataType dataType) {
        return null;
    }

    public R visitVariable(Variable variable) {
        return null;
    }

    public R visitLocalVariable(LocalVariable localVariable) {
        return visitVariable(localVariable);
    }

    public R visitExpression(Expression expression) {
        return null;
    }

}

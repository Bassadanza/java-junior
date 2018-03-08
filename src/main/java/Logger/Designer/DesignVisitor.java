package Logger.Designer;

import Logger.messages.*;

/**
 * Конкретная реализация декорирования выводимого сообщения
 * с префиксом
 */
public final class DesignVisitor implements Visitor {
    private static final String CHAR_PREFIX = "char: ";
    private static final String REFERENCE_PREFIX = "reference: ";
    private static final String PRIMITIVE_PREFIX = "primitive: ";
    private static final String PRIMITIVE_ARRAY_PREFIX = "primitives array: ";
    private static final String PRIMITIVE_ARRAY_MATRIX = "primitives matrix: ";

    public String export(final Command... args) {
        String decorated = "";
        for (Command messagee : args) {
            decorated = messagee.acceptVisitor(this);
        }
        return decorated;
    }

    @Override
    public String visitInt(final IntCommand intCommand) {
        return String.valueOf(intCommand.getCounter());
    }

    @Override
    public String visitString(final StringCommand stringCommand) {
        if (stringCommand.getCounter() > 1) {
            return stringCommand.getMessage()
                    + " (x"
                    + stringCommand.getCounter()
                    + ")";
        } else {
            return String.valueOf(stringCommand.getMessage());
        }
    }

    @Override
    public String visitBoolean(final BooleanCommand booleanCommand) {
        return PRIMITIVE_PREFIX
                + booleanCommand.getMessage();
    }

    @Override
    public String visitObject(final ObjectCommand objectCommand) {
        return REFERENCE_PREFIX
                + objectCommand.getMessage();
    }

    @Override
    public String visitChar(final CharCommand charCommand) {
        if (charCommand.getCounter() > 1) {
            return CHAR_PREFIX
                    + charCommand.getMessage()
                    + " (x" + charCommand.getCounter()
                    + ")";
        } else {
            return CHAR_PREFIX + String.valueOf(charCommand.getMessage());
        }
    }

    @Override
    public String visitByte(final ByteCommand byteCommand) {
        return String.valueOf(byteCommand.getCounter());
    }

    @Override
    public String visitArray(final ArrayCommand arrayCommand) {
        return PRIMITIVE_ARRAY_PREFIX + arrayDesign((int[]) arrayCommand.getMessage());
    }

    @Override
    public String visitMatrix(final MatrixCommand matrixCommand) {
        StringBuilder strBuff = new StringBuilder();
        strBuff.append("{").append(System.getProperty("line.separator"));
        for (int[] firstLevelArray : (int[][]) matrixCommand.getMessage()) {
            strBuff.append(arrayDesign(firstLevelArray))
                    .append(System.getProperty("line.separator"));
        }
        strBuff.append("}");
        return PRIMITIVE_ARRAY_MATRIX + strBuff.toString();
    }

    @Override
    public String visitMultydimArray(final MultyArrayCommand multyArrayCommand) {
        return null;
    }

    private String arrayDesign(final int[] arrayMessage) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{");
        for (int i = 0; i < arrayMessage.length; i++) {
            stringBuilder.append(arrayMessage[i]);
            if (i != arrayMessage.length - 1) {
                stringBuilder.append(", ");
            }
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }
}

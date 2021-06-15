package javatasks.classes.maintask;

public enum Faculty {
    MATHS("МАТ", "Математический"), FOREIGN_LANGUAGES("ИН-ЯЗ", "Иностранных языков"),
    PHYSICS("ФИЗ", "Физический"), ECONOMY("ЭКО", "Экономический"),
    GEOGRAPHY("ГЕО", "Географический"), BIOLOGY("БИО", "Биологический");

    private final String abbreviation;
    private final String name;

    Faculty(String abbreviation, String name) {
        this.abbreviation = abbreviation;
        this.name = name;
    }

    public static Faculty getRandomFaculty(int i) {
        Faculty fac = Faculty.MATHS;
        switch (i) {
            case 0:
                fac = Faculty.MATHS;
                break;
            case 1:
                fac = Faculty.FOREIGN_LANGUAGES;
                break;
            case 2:
                fac = Faculty.PHYSICS;
                break;
            case 3:
                fac = Faculty.ECONOMY;
                break;
            case 4:
                fac = Faculty.GEOGRAPHY;
                break;
            case 5:
                fac = BIOLOGY;
                break;
        }
        return fac;
    }

    public String getAbbreviation() {
        return abbreviation;
    }

    public String getName() {
        return name;
    }
}

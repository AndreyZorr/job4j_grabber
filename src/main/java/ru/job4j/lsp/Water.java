package ru.job4j.lsp;

class Swim {
}

class River extends Swim {
}

class Lake extends Swim {
}

class Water {
    public void read(Swim source) {
        if (source instanceof River) {
            readFromDatabase();
        } else if (source instanceof Lake) {
            readFromFile();
        }
    }

    private void readFromDatabase() {
    }

    private void readFromFile() {
    }
}
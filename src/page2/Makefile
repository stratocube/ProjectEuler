CC=g++
LDFLAGS=-lm
CFLAGS=-c -Wall
SOURCES=Problem76.cpp
OBJECTS=$(SOURCES:.cpp=.o)
EXECUTABLE=euler

all: $(SOURCES) $(EXECUTABLE)

$(EXECUTABLE): $(OBJECTS)
	$(CC) $(LDFLAGS) $(OBJECTS) -o $@ 

.cpp.o:
	$(CC) $(CFLAGS) $< -o $@

clean:
	-rm -f *.o $(EXECUTABLE)

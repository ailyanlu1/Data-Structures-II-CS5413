#include <stdio.h>
#include <stdlib.h>
#include "record.h"
#include "macros.h"

int main(int argc, char ** argv)
{
    if (argc != 2)
    {
        printf("Invalid usage -- must supply a file as an argument\n");
        printf("                 `pgm1 <path/to/file>`\n");
        return 1;
    }


    char * inFile = argv[1];
    LOG("Reading file %s\n", inFile);

    FILE * inFilePointer = fopen(inFile, "r");;
    char * line = NULL;
    size_t buffer_size = 0;
    ssize_t read_num = 0;
    read_num = getline(&line, &buffer_size, inFilePointer);

    int input_size = atoi(line);

    //done with line, free it
    FREE(line);

    LOG("Input size is %d\n", input_size);

    Record ** records = (Record **) malloc(sizeof(Record *) * input_size);
    read_records(inFilePointer, records, input_size);

    //cleanup
    free_records(records, input_size);

    if (inFilePointer)
    {
        fclose(inFilePointer);
    }

    return 0;
}


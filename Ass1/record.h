#ifndef PGM1_RECORD_H_
#define PGM1_RECORD_H_

#include <stdio.h>
#include "macros.h"

typedef struct Record {
    char * last_name;
    char * first_name;
    char * address;
    char * city;
    char * state;
    int zipcode;
} Record;

void free_records(Record ** records, int records_size);
void free_record(Record * record);
void read_records(FILE * fp, Record ** records, int records_to_read);
void init_record_with_string(char * str, size_t buffer_size, Record * record);
void print_record(Record * record);

#endif
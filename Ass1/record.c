#include "record.h"
#include <string.h>

void free_records(Record ** records, int records_size)
{
    if (!records) return;
    int i;
    for(i = 0; i < records_size; ++i) {
        free_record(records[i]);
    }
    FREE(records);
}

void free_record(Record *record)
{
    if (!record) return;
    FREE(record->last_name);
    FREE(record->first_name);
    FREE(record->address);
    FREE(record->city);
    FREE(record->state);
    FREE(record);
}

void read_records(FILE * fp, Record ** records, int records_to_read)
{
    if (!fp || !records) return;
    int i;
    char * line = NULL;
    size_t buffer_size = 0;
    ssize_t read_num = 0;
    for (i = 0; i < records_to_read; ++i) 
    {
        read_num = getline(&line, &buffer_size, fp);
        Record * record = (Record *) malloc(sizeof(Record));
        records[i] = record;
        init_record_with_string(line, buffer_size, record);
    }
    FREE(line);
}

void init_record_with_string(char * str, size_t buffer_size, Record * record)
{
    if (!record) return;
    char copy[buffer_size];
    strcpy(copy, str);

    record->last_name = strtok(copy, "|");
    record->first_name = record->last_name;
    record->address = strtok(NULL, "|");
    record->city = strtok(NULL, "|");
    record->state = strtok(NULL, "|");
    record->zipcode = 76168;
}

void print_record(Record * record)
{

}

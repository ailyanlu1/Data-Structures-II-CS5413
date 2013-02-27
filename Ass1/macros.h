#ifndef PGM1_MACROS_H_
#define PGM1_MACROS_H_

#include <stdio.h>
#include <stdlib.h>

//debug logging macro
#ifdef DEBUG
    #define LOG(fmt, args...) printf("%s:%d "fmt,__FILE__,__LINE__,args)
#else
    #define LOG(fmt, args...)
#endif

//safe free macro
#define FREE(ptr) if(ptr) free(ptr)

#endif

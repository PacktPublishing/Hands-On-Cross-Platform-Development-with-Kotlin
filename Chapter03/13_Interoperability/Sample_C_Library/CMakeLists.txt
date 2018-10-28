cmake_minimum_required(VERSION 3.12)
project(Sample_C_Library C)

set(CMAKE_C_STANDARD 99)

add_library(Sample_C_Library library.c library.h)
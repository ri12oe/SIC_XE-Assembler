# SIC/XE Assembler

## Updates - September 14, 2026

Today the project foundation was created for SIC/XE Project:

- Recreated the project folder structure under `src`, `tests`, and `docs`.
- Added a PowerShell build and run script at `build.ps1`. (for easier proccess)
- Confirmed the project uses the latest selected Java installation instead of assuming Java 17.
- Added the initial SIC/XE opcode table in `src/tables/OpcodeTable.java`.
- Added the SIC/XE register table in `src/tables/RegisterTable.java`.
- Added the core model classes for source lines, symbols, literals, intermediate lines, and instructions.
- Added local smoke-test assembly programs for minimal instructions, comments, blank lines, opcodes, and registers.
- Added VS Code Java settings so `src` is treated as the Java source root and compiled output is written to `out`.
- Confirmed that the PowerShell build script compiles and runs the current Java sources successfully.
- Deferred the official six-program test suite because no official test programs have been provided yet.

## Project Overview

This project will become a two-pass SIC/XE assembler. It will read SIC/XE assembly source code and eventually produce:

- A SIC/XE object program containing header, text, modification, and end records.
- A human-readable listing containing addresses, source statements, object code, and diagnostics.
- Symbol-table and literal-table reports.

The implementation is being developed using Java.

## Current Project Structure

```text
SIC_XE Assembler/
├── .vscode/
│   └── settings.json
├── docs/
│   └── PROJECT_PLAN.md
├── src/
│   ├── Main.java
│   ├── diagnostics/
│   ├── model/
│   │   ├── Instruction.java
│   │   ├── IntermediateLine.java
│   │   ├── Literal.java
│   │   ├── SourceLine.java
│   │   └── Symbol.java
│   ├── output/
│   ├── parser/
│   ├── pass/
│   └── tables/
│       ├── OpcodeTable.java
│       └── RegisterTable.java
├── tests/
│   ├── expected/
│   ├── programs/
│   └── unit/
├── build.ps1
└── README.md
```

## Build and Run on Windows

Open PowerShell at the project root:

```powershell
cd "the dic of your folder"
```

Run the build script:

```powershell
.\build.ps1
```

The script (Make sure to install Java properly. Here a link for instructions: https://www.geeksforgeeks.org/linux-unix/download-install-java-windows-linux-macos/):

1. Creates the `out` directory if it does not exist.
2. Finds Java source files under `src`.
3. Compiles them into `out`.
4. Runs the `Main` class when compilation succeeds.

To build manually instead:

```powershell
$sourceFiles = Get-ChildItem -Path src -Filter *.java -Recurse |
    ForEach-Object { $_.FullName }

javac -d out $sourceFiles
java -cp out Main
```

To check the installed Java tools:

```powershell
java -version
javac -version
```

## Current Model and Tables

The current model layer contains data classes used by later assembler stages:

- `SourceLine` stores parsed source-line fields.
- `Instruction` stores a mnemonic, opcode, and supported instruction formats.
- `Symbol` stores a label value and relocation information.
- `Literal` stores literal bytes and its assigned address.
- `IntermediateLine` connects a parsed source line with its Pass 1 address, object code, and diagnostics.

The table layer currently contains:

- `OpcodeTable` for SIC/XE instruction lookup.
- `RegisterTable` for register-name-to-number lookup.

## Local Smoke Tests

The local smoke programs are temporary development checks, not the official course test suite. They are stored in `tests/programs` and are intended to cover:

- Basic source structure and labels.
- Comments and blank lines.
- Opcode and register lookup.

Official six-program testing is deferred until sample programs or instructor requirements are available.

## Planned Work

The next milestone is the design freeze. Planned work includes:

- Resolve any remaining VS Code Java language-server package diagnostics.
- Confirm the names and contents of the local smoke programs.
- Define interfaces between the parser, Pass 1, Pass 2, diagnostics, and output writers.
- Decide the input and output formats.
- Add a design document describing the assembler data flow.
- Prepare the parser implementation checklist.

## SIC/XE Features Planned

The completed assembler is expected to support:

- Labels, operations, operands, comments, and blank lines.
- `START`, `END`, `BYTE`, `WORD`, `RESB`, `RESW`, `BASE`, `NOBASE`, `LTORG`, and `EQU`.
- Forward references and literals.
- Instruction formats 1, 2, 3, and 4.
- Simple, immediate, indirect, indexed, PC-relative, base-relative, and extended addressing.
- Object-program records and modification records.
- Diagnostics for invalid opcodes, duplicate symbols, undefined symbols, malformed constants, invalid registers, range errors, and invalid addressing combinations.

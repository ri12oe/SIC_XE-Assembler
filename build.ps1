New-Item -ItemType Directory -Force -Path out | Out-Null

$sourceFiles = Get-ChildItem -Path src -Filter *.java -Recurse |
    ForEach-Object { $_.FullName }

if ($sourceFiles.Count -eq 0) {
    $sourceFiles = @("Main.java")
}

javac -d out $sourceFiles

if ($LASTEXITCODE -eq 0) {
    java -cp out Main @args
}
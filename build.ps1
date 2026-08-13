$ErrorActionPreference = "Stop"
$project = Split-Path -Parent $MyInvocation.MyCommand.Path
$out = Join-Path $project "out\classes"
if (Test-Path (Join-Path $project "out")) {
    Remove-Item -LiteralPath (Join-Path $project "out") -Recurse -Force
}
New-Item -ItemType Directory -Force -Path $out | Out-Null
$sources = Get-ChildItem -LiteralPath (Join-Path $project "src") -Recurse -Filter *.java |
    Sort-Object FullName | ForEach-Object FullName
javac -d $out $sources
Copy-Item -Path (Join-Path $project "resources\*") -Destination $out -Recurse -Force
java -cp $out app.Main

@echo off
echo Checking port 8080...

for /f "tokens=5" %%a in ('netstat -aon ^| findstr :8080') do (
    echo Killing process %%a using port 8080
    taskkill /F /PID %%a
)

echo Port 8080 is now free.
pause
SCRIPT_PATH="/home/user/tp-r504/TP14/scan.sh"

(crontab -l ; echo "*/5 * * * * $SCRIPT_PATH") | crontab -


